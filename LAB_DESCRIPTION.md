# OSGi Lab

_OSGi Asteroid Game_

### Introduction

In this assignment, we apply the OSGi component framework in the Asteroid game setting.

### Objectives

The objective of this assignment is to get familiar with the OSGi framework, provide sufficient information to get
started with CODA practice using OSGi, and appreciate the component-oriented features of the OSGi framework.

### Classwork

- Inspect the textbook example how to use the OSGi Declarative Services and BundleContext
  API, see Chapter 5 in [MSS13](#mss13).
- Implement components from the Asteroids game using the OSGi framework, see
  [OSGiRec](https://drive.google.com/file/d/1_FU1ax9Vad_a4QY5R358dP_xKZTcNEJE/view) for more details.

  Use both Declarative Services and the BundleContext API. For example implement the move and enemy components.

- You can create your own project from scratch based on maven pax archetypes and the command line, see
  [OSGiPax](https://github.com/sweat-tek/SB4-KOM-F20/tree/master/PaxAsteroids).

Get familiar with the maven goals describes in the
[readme.txt](https://github.com/sweat-tek/SB4-KOM-F20/blob/master/PaxAsteroids/readme.txt) file.

**Note** the that maven has to be setup with the `JAVA_HOME` environment variable that is pointing to
**JDK version 1.8**.

- Inspect the [PaxAsteroids] example and use the Apache gogo shell to start and stop OSGi bundles.

### Literature

##### [MSS13](https://drive.google.com/file/d/19_EzdKmwgYUJTzAoxpNLTtkXbUZvejvB/edit)

> P. Manickam, S. Sangeetha, and S.V. Subrahmanya. _Component-Oriented Development
> and Assembly: Paradigm, Principles, and Practice using Java_. Infosys Press. Taylor &
> Francis, 2013.
