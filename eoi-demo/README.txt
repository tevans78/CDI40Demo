This demo contains four modules

- web: A war containing the web application
- bce: A jar containing a CDI Build Compatible Extension
- cdi10beansxml: A jar containing a CDI 1.0 style beans.xml (unversioned)
- emptybeansxml: A jar contaiming an empty beans.xml

Build everything from the parent eoi-demo project

- mvn clean install

Go into the web module to run the app in Liberty

- mvn liberty:run

