# spring-social-and-security-5
Example application showing how to mix Spring Security 5.0.0.M3 OAuth2 and Spring Social

This is a slightly altered version of https://github.com/spring-projects/spring-security/tree/master/samples/boot/oauth2login to capture the Facebook access token and use it to create a request-scoped `FacebookTemplate` bean.

After authenticating with Facebook, point your browser at http://localhost:8080/feed to see the results.

The purpose of this project is to demonstrate how this might be done and to also help me drive out future plans for Spring Social that leverage Spring Security's OAuth2 support.
