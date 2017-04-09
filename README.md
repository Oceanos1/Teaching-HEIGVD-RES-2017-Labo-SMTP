# Teaching-HEIGVD-RES-2017-Labo-SMTP

## Objectives
This program allows a user to send pranks by email: once the user has entered a list of email adresses, random groups are created. In each group, one sender will be selected and the program will send pranks to other adresses in the group. The SMTP server and port via which the emails are sent can be configured by the user, as can all the adresses and pranks.

## Instructions

* All the config files are contained within the `./config/` directory. 
* The adresses of the victims should be entered into the `victimes.RES.utf8` file, one per line.
* The `config.properties` file can be used to configure the SMTP server, port, witness email to be CC'd and the number of adress groups to be used.
* The `messages.utf8` file should contain the messages you wish to send. The first line of a message should be a subject using the format `Subject: example subject`. After the subject, one blank line should be left before the body of the message is written. To end a message, another blank line should be added followed by a line containing only the symbols `==`.

## Email groups
Groups are created randomly from the list of adresses entered into the config files. The minimum group size is 3. One member of the group is randomly selected to be the sender, the rest of the group are receivers. The number of groups can be modified in the `config.properties` file.

      







