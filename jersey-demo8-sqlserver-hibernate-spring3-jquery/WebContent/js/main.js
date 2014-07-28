// The root URL for the RESTful services
var rootURL = 'http://localhost:8089/RestDemo/rest/users';

var currentUser;

// Retrieve wine list when application starts 
findAll();

// Nothing to delete in initial application state
$('#btnDelete').hide();

$('#btnAdd').click(function() {
	addUser();
	return false;
});

$('#btnSave').click(function() {
 
	updateUser();
	return false;
});

$('#btnClear').click(function() {
	newUser();
	return false;
});


$('#btnDelete').click(function() {
	deleteUser();
	return false;
});

$('#userList a').live('click', function() {
	findById($(this).data('identity'));
});

$('#btnRefreash').click(function() {
	findAll();
	return false;
});
 

function newUser() {
	$('#btnDelete').hide();
	currentUser = {};
	renderDetails(currentUser); // Display empty form
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}

 
function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();

			console.log('findById success: ' + data.userName);
			currentUser = data;
			renderDetails(currentUser);
		}
 
	});
}

function addUser() {
	console.log('addUser');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('User created successfully');
			$('#btnDelete').show();
			$('#userId').val(data.userId);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addUser error: ' + textStatus);
		}
	});
}

function updateUser() {
	console.log('updateUser');
	$.ajax({
		type: 'PUT',

		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		
		success: function(data, textStatus, jqXHR){
			alert('User updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateUser error: ' + textStatus);
		}
	});
}

function deleteUser() {
	console.log('deleteUser');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#userId').val(),
		success: function(data, textStatus, jqXHR){
			alert('user deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('delete user error');
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#userList li').remove();
	$.each(list, function(index, data) {
		$('#userList').append('<li><a href="#" data-identity="' + data.userId + '">'+data.userName+'</a></li>');
	});
}

function renderDetails(data) {
	$('#userId').val(data.userId);
	$('#userName').val(data.userName);
	$('#age').val(data.age);
 
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var userId = $('#userId').val();
	return JSON.stringify({
		"userId": userId == "" ? null : userId, 
		"userName": $('#userName').val(), 
		"age": $('#age').val() 
		});
}
