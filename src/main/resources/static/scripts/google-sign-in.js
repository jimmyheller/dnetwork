$(document).ready(function () {
    $('form').hide();

})

function onSignIn(googleUser) {


    var profile = googleUser.getBasicProfile();
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());


    var dnetUser = {
        fullName: profile.getName(),
        givenName: profile.getGivenName(),
        familyName: profile.getFamilyName(),
        imageUrl: profile.getImageUrl(),
        email: profile.getEmail()
    };
    $('#fullName').val(dnetUser.fullName);
    $('#givenName').val(dnetUser.givenName);
    $('#familyName').val(dnetUser.familyName);
    $('#imageUrl').val(dnetUser.imageUrl);
    $('#email').val(dnetUser.email);
    $('form').show();
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);


    $("#registerFormSubmitBtn").click(function (event) {
        event.preventDefault()
        $.ajax({
            url: "/oauth/google",
            type: "POST",
            data: JSON.stringify(dnetUser),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            }
        });
    });

}