
# DB update based on JSON file

This app was made for the needs of one small company during my internship. The purpose of application is to fetch JSON file (which contains 50k+ objects) and to update current MySQL database of companies (which counts 50k+ records). Althogh this task could be done without framework, i decided to use Spring framework.


App connects to database. When required URL (which contains large JSON file) is passed to appropriate endpoint through postman as request parameter, data is being fetched from JSON and MySQL database.
Every company which exists in JSON and not in DB is added in DB and every company which exists in DB and not in JSON is being deleted.

Actually app generates SQL script file with appropriate UPDATE and INSERT statements which can be run on any computer locally which has database.
