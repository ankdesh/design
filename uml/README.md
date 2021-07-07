# UML 2.0 #

## Structural Diagrams ##

### Class Diagram ###

Class diagram presents the classes of the objects and their relationships.

#### Class ####
Consists of three compartments: Name, State and Behavior

![Class](notation/classes/class-1.png)

State is a set of attributes and behavior is a set of operations

![Class](notation/classes/class-2.png)

#### Association ####

Association represents "uses and leaves" relationship. 

![Class](notation/classes/association-1.png)

Can be bi-directional as well.

![Class](notation/classes/association-2.png)

Objects in a relation play a role and the cardinality can be one-to-one, one-to-many and etc., 

![Class](notation/classes/association-3.png)

An illustration:

```
class Security {
    private CredentialStore store;
    ....
}
```

![Class](notation/classes/association-4.png)

#### Aggregation ####

Represents "owns and share" relationship.

![Class](notation/classes/aggregation-1.png)

Illustration: A connection pool is manages 5 connections for its clients. 

```
class ConnectionPool {
    private Connection[5] connections;
    ...
}
```

![Class](notation/classes/aggregation-2.png)

#### Composition ####

Represents "part-of" relationship. The part is destroyed along with the whole. 

![Class](notation/classes/composition-1.png)

Illustration: The TitleBar is part of a Window

![Class](notation/classes/composition-2.png)

#### Dependency ####

Represents "uses and throws" relationship. 

![Class](notation/classes/dependency.png)

#### Association Class ####

Represents the details of an association.

![Class](notation/classes/association-class.png)

#### Generalization ####

Represents "is-a" relation. The derived object "is-a" special kind of base object.

![Class](notation/classes/generalization-1.png)

#### Interface ####

Represents service contract. 

![Class](notation/classes/interface-1.png)

Illustration

![Class](notation/classes/interface-2.png)

#### Realization ####

Represents implementation of a contract. 

![Class](notation/classes/realization-1.png)

Illustration: 

![Class](notation/classes/realization-2.png)

#### Class Diagram Illustration ####

![Class](notation/classes/class-diagram.png)

### Package Diagram ###

#### Package ####
![Class](notation/packages/package-1.png)

![Class](notation/packages/package-2.png)

#### Package Relations ####
![Class](notation/packages/package-use-1.png)

![Class](notation/packages/package-use-2.png)

![Class](notation/packages/package-contain-1.png)

![Class](notation/packages/package-contain-2.png)

![Class](notation/packages/package-classes.png)

#### Package Diagram Illustration ####
![Class](notation/packages/package-illustration.png)

### Component Diagram ###

#### Component ####
![Class](notation/components/component-1.png)

#### Component Relations ####
![Class](notation/components/component-2.png)

![Class](notation/components/component-3.png)

![Class](notation/components/component-4.png)

![Class](notation/components/component-5.png)

#### Component Diagram Illustration ####
![Class](notation/components/component-illustration.png)

### Deployment Diagram ###

#### Node ####
![Class](notation/deployment/deployment-1.png)

#### Node Relations ####
![Class](notation/deployment/deployment-2.png)

![Class](notation/deployment/deployment-3.png)

![Class](notation/deployment/deployment-4.png)

#### Deployment Diagram Illustration ####
![Class](notation/deployment/deployment-5.png)

## Behavioral Diagrams ##

### Usecase Diagram ###

#### Subject ####
![Class](notation/usecases/subject.png)

#### Usecase ####
![Class](notation/usecases/usecase.png)

#### Actor ####
![Class](notation/usecases/actor.png)

#### Association ####
![Class](notation/usecases/usecase-association.png)

#### Extending Usecase ####
![Class](notation/usecases/usecase-extension.png)

#### Extending Actor ####
![Class](notation/usecases/actor-generalization.png)

#### Including Usecase ####
![Class](notation/usecases/usecase-inclusion.png)

#### Usecase Diagram Illustration ####
![Class](notation/usecases/usecase-diagram.png)

### Activity Diagram ###

#### Action ####
![Class](notation/activities/activity-1.png)

#### Activity Flows ####
![Class](notation/activities/activity-2.png)

![Class](notation/activities/activity-3.png)

![Class](notation/activities/activity-4.png)

![Class](notation/activities/activity-5.png)

![Class](notation/activities/activity-6.png)

![Class](notation/activities/activity-7.png)

![Class](notation/activities/activity-8.png)

#### Activity Partitions ####

![Class](notation/activities/activity-9.png)

#### Activity Exceptions ####

![Class](notation/activities/activity-10.png)

![Class](notation/activities/activity-11.png)

![Class](notation/activities/activity-12.png)

![Class](notation/activities/activity-13.png)

![Class](notation/activities/activity-14.png)

![Class](notation/activities/activity-15.png)

![Class](notation/activities/activity-16.png)

![Class](notation/activities/activity-17.png)

#### Activity Illustrations ####

![Class](notation/activities/activity-18.png)

![Class](notation/activities/activity-19.png)

![Class](notation/activities/activity-20.png)

![Class](notation/activities/activity-21.png)

### State Chart Diagram ###

#### State ####
![Class](notation/state/state-1.png)

#### State Transitions ####
![Class](notation/state/state-2.png)

![Class](notation/state/state-3.png)

![Class](notation/state/state-4.png)

![Class](notation/state/state-5.png)

![Class](notation/state/state-6.png)

#### Kinds of States ####

![Class](notation/state/state-7.png)

![Class](notation/state/state-12.png)

![Class](notation/state/state-9.png)

![Class](notation/state/state-10.png)

![Class](notation/state/state-11.png)

![Class](notation/state/state-8.png)


### Sequence Diagram ###

#### Lifeline ####
![Class](notation/sequences/sequence-1.png)

#### Interactions ####
![Class](notation/sequences/sequence-2.png)

![Class](notation/sequences/sequence-3.png)

![Class](notation/sequences/sequence-4.png)

![Class](notation/sequences/sequence-6.png)

#### Fragments ####
![Class](notation/sequences/sequence-7.png)