# QR-Code-Based-Passport-Identification

Project description:

The propose system consist of raspberry pi module with QR code decoding features and QR code reader will be a camera that will connect to Raspberry pi’s USB port. 
Each person having their own QR code card in which the passport ID is saved. The OR code generated with the help of programming. Camera will scan the code and give it to raspberry pi that will decode the QR code and check the ID of person on web page that is designed in Raspberry pi. Web page is nothing but a data base where we will save the user ID which is a valid one. If person has a valid ID then GREEN led will glow and gate (motor on) will open. If person is unauthorized or ID is invalid the RED led will glow and Gate will not open, at the same time buzzer will beep. 
For add a new user we can encode the QR code as well decode it. For encoding the QR code admin requires a server to connect with web page then admin can add or change the information on database or web page which is in raspberry pi.
For connecting with raspberry pi, wifi module is used. The web page designed in raspberry pi can access by other device like mobile or PC that should have network in range, for that we are using wifi. That can be access by admin

Conclusion:

The proposed method will be used to demonstrate on a sample passport to verify the passport text details. Therefore we choose a QR code based password identification which reduces the human work and efforts. Only admin is able to use the database related problems and changes. Only valid person can enter after verification, and it needs very less time and efforts. Security level is increased in this system as QR code having with each person as a valid ID.
