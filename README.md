# menu
a description of the problem domain your team is tentatively wanting to focus on in the project. (e.g., trivia, finance, real estate, etc.…) 
 
The problem domain that our project will focus on is Recipe Organizer, a program that can store and recommend recipes based on words entered by users and allow users to upload and store their own recipes. 
 
a brief, high-level description of what kind of application your team is thinking of developing. 
This is mostly just so we can give you some initial feedback on whether your team might want to reconsider your project direction. 
 
Functions: 
Provide and recommend recipes (ingredients, instructions, etc.)  based on tags entered from users 
map {name: class: recipe (name: ingredients: string, instructions: string, tags: list of strings)} 
Organize recipes by tags (e.g., gluten-free, nuts-free) 
Users can upload and edit their own recipes 
Store customized recipe 
Users can create their own folder and save the recipes they liked to these folders. 
user customization  
use of an API relevant to the domain 
 
a link to the documentation for an API your team can use related to the domain. 
https://spoonacular.com/food-api/docs#Search-Recipes-Complex 
a screenshot of using a tool to try out the API (like https://www.postman.com/Links to an external site. or https://hoppscotch.io/Links to an external site.Links to an external site.) 
 
example output of running your Java code (see below). 
a list of any technical problems blocking progress (if any). 
Technical problems blocking progress: 
Which json version to use? We can’t find org.json:json:20230618, so we used json-20220924.jar instead. What are the differences? 
How to utilize the requested json file and extract data based on user’s inputs? 
To what extent should we depend on API? There are some use cases/sample use cases listed on the API website we find, can we use them? 
In the code snippet generated by our API, it called Request.Builder.method(), it says that method gets must not have a request body? Why is that the case? 
If we want to provide some additional services that can not be accomplished by the API we find, is it
https://github.com/yuxizzz/menu/issues/1#issue-1921081998
