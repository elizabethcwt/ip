# User Guide

*  [Introduction and Flowchart](#introduction-and-flowchart)
*  [Quick Start](#quick-start)
*  [Features](#features)
   *  [Adding a new task](#adding-a-new-task): `todo` `deadline` `event`
   *  [Check/Update an existing task](#check/update-an-existing-task): `list` `done` `delete` `find`
   *  [Exiting the program](#exiting-the-program): `bye`
*  [Command Summary](#command-summary)

<a id="introduction-and-flowchart"></a>
## Introduction and Flowchart
FriendlyBot is your friendly todo list, that helps you to **manage three types of tasks**:
* Todos,
* Deadlines, and
* Events

FriendlyBot provides several user commands, for more functionality when managing your tasks.
These commands are shown more clearly in the flowchart below.
<br><br>![FriendlyBot Basic Flowchart](FriendlyBot%20Basic%20Flowchart.png)

<a id="quick-start"></a>
## Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `ip.jar` from [here](https://github.com/elizabethcwt/ip/releases/tag/A-Release).
1. Copy and place the file into a folder on your computer.
1. Open your computer's terminal, navigate to the `ip.jar` file and run the app.
1. Refer to the features below for details of the commands available in FriendlyBot.

<a id="features"></a>
## Features

<a id="adding-a-new-task"></a>
### Adding a new task
#### Adding a todo task: `todo`
Adds a todo task in your task list.
<br>Format: `todo [todo task description]`
<br>Examples:
<br>
Input: `todo read book`
<br>Expected output:
<br><br>![todo expected outcome](todo.png)

Note:
* `[T]` - Task is of **todo** type.
* `[✘]` - Task is **not done**.
   
#### Adding a deadline task: `deadline`
Adds a deadline task in your task list.
<br>Format: `deadline [deadline task description] /by [deadline date]`
<br>Entering a date in `YYYY-MM-DD` format converts the date to `MONTH DD YEAR` format.
<br>Examples:
<br>
Input: `deadline return book /by Sunday, 2pm`
<br>Expected output:
<br><br>![deadline1 expected outcome](deadline1.png)
    
Input: `deadline return book /by 2pm, 2020-09-25`
<br>Expected output:
<br><br>![deadline2 expected outcome](deadline2.png)
  
Note:
* `[D]` - Task is of **deadline** type.
* `[✘]` - Task is **not done**.

#### Adding an event task: `event`
Adds an event task in your task list.
<br>Format: `event [event task description] /at [event location]`
<br>Examples:
<br>
Input: `event project meeting /at school`
<br>Expected output:
<br><br>![event expected outcome](event.png)

Note:
* `[E]` - Task is of **event** type.
* `[✘]` - Task is **not done**.
   
<a id="check/update-an-existing-task"></a>
### Check/Update an existing task
#### Listing all tasks: `list`
Lists all the tasks (todo, deadline and event) in your current task list.
<br>Format: `list`
<br>Examples:
<br>
Input: `list`
<br>Expected output:
<br><br>![list expected outcome](list.png)

#### Marking tasks as done: `done`
Marks specific task in your task list as done.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `done 1`
<br>Expected output:
<br><br>![done1 expected outcome](done1.png)

Note:
* `[✓]` - Task is **done**.

#### Deleting a task: `delete`
Deletes a specific task in your current task list.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `delete 2`
<br>Expected output:
<br><br>![delete2 expected outcome](delete2.png)
    
#### Finding a task: `find`
Finds relevant tasks in your current task list based on keywords you provide.
<br>Format: `find [keyword(s)]`
<br>Examples:
<br>
Input: `find book`
<br>Expected output
<br><br>![find expected outcome](find.png)

<a id="exiting-the-program"></a>
### Exiting the program: `bye`
Exits FriendlyBot.
<br>Examples:
<br>
Input: `bye`
<br>Expected output:
<br><br>![bye expected outcome](bye.png)

<a id="command-summary"></a>
## Command Summary

|Action|Format|Examples|
|--------------|----------------|----------------|
|Add todo|`todo [todo task description]`|`todo read book`|
|Add deadline|`deadline [deadline task description] /by [deadline date]`|`deadline return book /by 2pm, 2020-09-25`|
|Add event|`deadline [event task description] /at [event location]`|`event project meeting /at school`|
|List|`list`|
|Done|`done [task number in task list]`|`done 2`|
|Delete|`delete [task number in task list]`|`delete 2`|
|Find|`find [keyword(s)]`|`find book`|
|Bye|`bye`|
