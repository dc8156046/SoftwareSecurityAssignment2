# ManageComputers

ITSC320 - A2

## Introduction

The use of secure coding practices is valuable when creating software systems that must be as resistant to attacks as possible. In class we have discussed a number of different techniques which directly affect the way we write our code when considering security as an important non-functional requirement for a system, including: input validation, use of composition over inheritance for reuse of existing system functionality, and use of immutable versus mutable classes/objects.

For this assignment you are being given a fully functioning Java application called ManageComputers which manages a list of computers (Desktop and/or Laptop) and their details. The application has been developed without much input validation, using inheritance to reuse class functionality, and with mutable classes in the design. Your task for this assignment is to rewrite this application to incorporate the following:

- Provide whitelist-style input validation for the data entered for each computer managed by the system
- Rewrite the Computer, Desktop and Laptop classes to make them immutable. You will need to rewrite other code in the application once this is done to allow the main part of the program to use the revised classes
- Rewrite the Desktop and Laptop to use composition instead of inheritance to reuse/incorporate the existing functionality of the Computer class. The Desktop and Laptop classes must not themselves directly manage any data that the Computer class holds, e.g. CPU, RAM, Disk attribute values

Once the program is changed as described above the application functionality should appear exactly the same from the perspective of an end-user, i.e. they should not notice any functional differences in the revised version of the program once the changes are made.
