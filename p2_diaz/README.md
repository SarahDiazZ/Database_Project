## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Running Code
cd into the 'src' folder; This is where the phase2.java is located
java -cp "[file path]/mysql-connector-j-8.3.0.jar" phase2.java
The output will ask for input like this:
    Enter procedure name: [procedure_name]