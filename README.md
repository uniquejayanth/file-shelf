# file-shelf

Project Name: File Shelf 

Generic Name: File Manager

This is a custom-built file manager for Android developed to understand how a typical file manager works and to learn more about application development.
This application is a basic file manager without additional bells and whistles. 

You can perform following operations on a file using this application:
  1. Details (Get metadata and additional details like last modified, path etc..)
  2. Rename (It's very important to manipulate a file and I have added this functionality)
  3. Delete (As the name suggests, it's used to delete a file or a folder)
  4. Share (Used to share files between apps) !This particular feature is currently buggy!

As you enter the home-screen you are presented with images, docs, music, videos and apk's.
Below that fragment you can access recent files that you have downloaded or stored.

You can use the hamburger menu to open a menu which contains three fragments Home, Internal and SD-card.
Home contains the home-screen contents, Internal contains the internal storage files and folders. 
!Hidden files cannot be accessed!
You can also access SD-card, but if it's not inserted the app might crash.
Currently I'm facing trouble with optimizing the applicatioin for android 12 and later but will soon try to fix it.

