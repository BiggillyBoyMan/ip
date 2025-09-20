Nami - User Guide

Nami is a task management application designed to help you organize your tasks easily using either a Command Line Interface (CLI) or Graphical User Interface (GUI). If you’re familiar with typing commands, Nami will be faster than traditional GUI applications!

Quick Start

Ensure you have Java 17 or above installed.

Download the latest .jar file:

[Download the latest JAR from here]

Copy the JAR file to the folder where you want to run Nami.

Run the application:

Open a terminal in the folder where the JAR file is located.

Run the following command:

java -jar Nami.jar


This should open a GUI window if you are using the GUI version. If you’re using CLI, the terminal will show the text-based interface.

Features
Adding a Task: add

Adds a task to the task list. There are 3 types of tasks: todo, events, and deadlines.

Format:

For Todo: add t/Todo DESCRIPTION

For Deadline: add t/deadline DESCRIPTION /by DATE (DD/MM/YYYY HH:MM)

For Event: add t/event DESCRIPTION /from DATE (DD/MM/YYYY HH:MM) /to DATE (DD/MM/YYYY HH:MM)

Listing All Tasks: list

Shows a list of all tasks in the task list.

Format: list

Locating Tasks by Description: find

Finds tasks whose descriptions contain the given keywords.

Format: find KEYWORD [MORE_KEYWORDS]

Examples:

find assignment

find project deadline

Deleting a Task: delete

Deletes the specified task from the task list.

Format: delete INDEX

Examples:

delete 2

Marking / Unmarking tasks as done: mark / unmark

Format: mark INDEX / unmark INDEX

Examples:

mark 2

unmark 2

Exiting the Program: bye

Exits the application.

Format: bye

Saving the Data

Tasks are automatically saved after any change (add, edit, delete) to the task list. You do not need to manually save the data.

Editing the Data File

The tasks data is stored in a file: data/nami.txt.

Known Issues

Command Summary

Action	Format	Examples
Add	add t/TASK_TYPE d/DESCRIPTION	Example: add t/todo d/Complete homework
List	list
Delete	delete INDEX	Example: delete 1
Find	find KEYWORD [MORE_KEYWORDS]	Example: find project
Exit	bye
Notes:

Task Types (t/TASK_TYPE): The task can be a todo, deadline, or event.

Keywords for find: Search is case-insensitive. The order of the keywords doesn’t matter.