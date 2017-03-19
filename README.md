# ProtoEPIC

- Basic version of ProtoEPIC - a system for managing project documentation.

IMPLEMENTED:
- Login screen for the user to enter his credentials:
    - displaying an error message if the credentials are invalid
    - informing the user when he has been logged out
  
 - User database implemented for now as a simple Map containing usernames and passwords
 - ProjectBrowser screen shows a greeting to the user and offers a "log out" link
 
 - ProjectBrowser screen:
    - showing all available projects and enabling the user to access their documentation
 
 -  ProjectView screen:
    - showing a list of project/document specific fields containing document information
    - basic view of document text fields/boxes implemented
    - each document from the returned list should be accessible by a link moving the user to the document view
    
 - DocumentView screen:
    - document should have the ability to upload/download files corresponding to the document profile
    
 - Automatic tests:
    - unit tests for classes (started)
    - automatic tests to populate app with projects + documents
---------------------------------------------------------------------------------------------------------------------
TO-BE-IMPLEMENTED:
- ProjectBrowser screen:
    - according to user rights user/editor/admin offer appropriate edition rights
    - ability to browse projects for user, edit for editor and edit/add/delete projects for admin
  
-  ProjectView screen:
    - boxes should offer the ability to search and find appropriate documents based on the inserted fields
    
- DocumentView screen:
    - document should show the same project-specific boxes populated with information about the document

- Automatic tests:
    - unit tests for classes
