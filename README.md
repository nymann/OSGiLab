# NetBeansLab2

<https://user-images.githubusercontent.com/7005867/168393245-33049515-d750-43de-98c9-f73cd8eee775.mp4>

### Running the game

##### On the off-chance that someone else is running this

The path to the updates.xml path in [Bundle.properties](https://github.com/nymann/NetBeansLab2/blob/master/Asteroids/SilentUpdate/src/main/resources/org/netbeans/modules/autoupdate/silentupdate/resources/Bundle.properties) is hard-coded.

You can fix it manually or run `make fix-bundle-path`.

##### Via make target

```sh
make run
```

##### Via maven

```sh
mvn install -DskipTests -f Asteroids/pom.xml
mvn nbm:run-platform -f Asteroids/application/pom.xml
```
