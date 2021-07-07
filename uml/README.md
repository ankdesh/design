# UML 2.0 #

## 1. Structural Diagrams ##
Presents structural aspects of a system.

### 1.1. Class Diagram ###

Class diagram presents the classes of the objects and their relationships.

#### 1.1.1. Class ####
Consists of three compartments: Name, State and Behavior.

![Class](notation/classes/class-1.png)

State is a set of attributes and behavior is a set of operations.

![Class](notation/classes/class-2.png)

#### 1.1.2. Association ####

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

#### 1.1.3. Aggregation ####

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

#### 1.1.4. Composition ####

Represents "part-of" relationship. The part is destroyed along with the whole. 

![Class](notation/classes/composition-1.png)

Illustration: The TitleBar is part of a Window.

![Class](notation/classes/composition-2.png)

#### 1.1.5. Dependency ####

Represents "uses and throws" relationship. 

![Class](notation/classes/dependency.png)

#### 1.1.6. Association Class ####

Represents the details of an association.

![Class](notation/classes/association-class.png)

#### 1.1.7. Generalization ####

Represents "is-a" relation. The derived object "is-a" special kind of base object.

![Class](notation/classes/generalization-1.png)

#### 1.1.8. Interface ####

Represents service contract. 

![Class](notation/classes/interface-1.png)

Illustration:

![Class](notation/classes/interface-2.png)

#### 1.1.9. Realization ####

Represents implementation of a contract. 

![Class](notation/classes/realization-1.png)

Illustration: 

![Class](notation/classes/realization-2.png)

#### 1.1.10. Class Diagram Illustration ####

![Class](notation/classes/class-diagram.png)

### 1.2. Package Diagram ###
Represents logical grouping of classes.

#### 1.2.1. Package ####
A package consists of classes and sub-packages that are logically close to each other.

![Class](notation/packages/package-1.png)

Various languages implement a pacakge as a modules, a namespaces and etc.,

![Class](notation/packages/package-2.png)

#### 1.2.2. Package Relations ####
A package may import/depend on other package.

![Class](notation/packages/package-use-1.png)

Illustration: 

```
package com.glarimy.client;

import com.glarimy.api;
....

```

![Class](notation/packages/package-use-2.png)

A package may include another package.

![Class](notation/packages/package-contain-1.png)

Illustration: 
```
    namespace com.glarimy.api {
        namespace exceptions {
            ...
        }
        ...
    }
```

![Class](notation/packages/package-contain-2.png)

#### 1.2.3. Package Diagram Illustration ####

Illustration-1: 

![Class](notation/packages/package-classes.png)

Illustration-2:

![Class](notation/packages/package-illustration.png)

### 1.3. Component Diagram ###

Represents functional grouping of classes.

#### 1.3.1. Component ####

A cohessive modular unit of functionality.

![Class](notation/components/component-1.png)

#### 1.3.2. Component Relations ####

A component is always associated with one or more interfaces.

![Class](notation/components/component-2.png)

A component provides an interface.

![Class](notation/components/component-3.png)

A component requires an interface.

![Class](notation/components/component-4.png)

Two components are coupled through an interface.

![Class](notation/components/component-5.png)

#### 1.3.3. Component Diagram Illustration ####
![Class](notation/components/component-illustration.png)

### 1.4. Deployment Diagram ###
Represents association between logical artifacts and physical devices.

#### 1.4.1. Node ####

A physical machine, device, environment and etc., 

![Class](notation/deployment/deployment-1.png)

#### 1.4.2. Node Relations ####

A component might be deployed on to a node.

![Class](notation/deployment/deployment-2.png)

An artifact like configuration file and etc., might be deploed on to a node.

![Class](notation/deployment/deployment-3.png)

Two nodes might be connected physically via network and etc., 

![Class](notation/deployment/deployment-4.png)

#### 1.4.3. Deployment Diagram Illustration ####
![Class](notation/deployment/deployment-5.png)

## 2. Behavioral Diagrams ##
Presents the dynamic aspects of a system.

### 2.1. Usecase Diagram ###
Represents the system from an external perspective.

#### 2.1.1. Subject ####
The system or a module which is being presented from an external perspective .

![Class](notation/usecases/subject.png)

#### 2.1.2. Usecase ####

The feature/functionality of the subject as seen from outside of the subject.

![Class](notation/usecases/usecase.png)

#### 2.1.3. Actor ####

The role of external users of the subject.

![Class](notation/usecases/actor.png)

#### 2.1.4. Association ####

An actor always associates with one or more usecases. Similarly, a usecause is always assoiated with one more actors. 

![Class](notation/usecases/usecase-association.png)

#### 2.1.5. Extending Usecase ####

A usecase might have a specialized behavior under certian conditions.

![Class](notation/usecases/usecase-extension.png)

#### 2.1.6. Extending Actor ####

An actor may extend the previleges of another actor.

![Class](notation/usecases/actor-generalization.png)

#### 2.1.7. Including Usecase ####

A usecase might have another usecase as a part of it.

![Class](notation/usecases/usecase-inclusion.png)

#### 2.1.8. Usecase Diagram Illustration ####
![Class](notation/usecases/usecase-diagram.png)

### 2.2. Activity Diagram ###
Represents a workflow in the system.

#### 2.2.1. Action ####
A workflow/activity is a set of actions arranged in a logical order.

![Class](notation/activities/activity-1.png)

#### 2.2.2. Activity Flows ####

Every activity starts from an "initial action".

![Class](notation/activities/activity-2.png)

Every activity ends with a "terminal action".

![Class](notation/activities/activity-3.png)

Usually, the control of an activity is passed from one action to another action.

![Class](notation/activities/activity-4.png)

Sometimes, the control of an activity is passed to the actions based on conditions.

![Class](notation/activities/activity-5.png)

Often, several action paths might merge at a common point also.

![Class](notation/activities/activity-6.png)

Also, the control of an activity might be passed to multiple actions in parallel.

![Class](notation/activities/activity-7.png)

Similarly, several action paths join together before passing the control to the next action.

![Class](notation/activities/activity-8.png)

#### 2.2.3. Activity Partitions ####

Several actions might be grouped together for better readability.

![Class](notation/activities/activity-9.png)

#### 2.2.4. Special Actions ####

An action might be part of an interruptable region.

![Class](notation/activities/activity-10.png)

An action can be very complex which demands further granularity.

![Class](notation/activities/activity-11.png)

An action might be asynchronous as well.

![Class](notation/activities/activity-12.png)

Sometimes, delay/wait/etc., might also needs to be represented.

![Class](notation/activities/activity-13.png)

It is also possible to show an object flow between actions.

![Class](notation/activities/activity-14.png)

Exception handlers are special actions.

![Class](notation/activities/activity-15.png)

As an alternative to object flows, input/output pins are also used.

![Class](notation/activities/activity-16.png)

Illustration of pins:

![Class](notation/activities/activity-17.png)

#### 2.2.5. Activity Illustrations ####

Illustration-1:

![Class](notation/activities/activity-18.png)

Illustration-2:

![Class](notation/activities/activity-19.png)

Illustration-3:

![Class](notation/activities/activity-20.png)

Illustration-4:

![Class](notation/activities/activity-21.png)

### 2.3. State Chart Diagram ###
Represents the system as a state machine.

#### 2.3.1. State ####
A snapshot of the system at a given time.

![Class](notation/state/state-1.png)

#### 2.3.2. State Transitions ####

Every state machine have an initial state.

![Class](notation/state/state-2.png)

Every state machine have a terminal state.

![Class](notation/state/state-3.png)

System moves from one state to another state up on a trigger/event/etc., 

![Class](notation/state/state-4.png)

The triggered transition may happen only if a pre-condition is satisfied.

![Class](notation/state/state-5.png)

Each system may take certain actions upon entering a state, while in the given state and while leaving the state.

![Class](notation/state/state-6.png)

#### 2.3.3. Kinds of States ####

A composite state is a super state of several sub states.

![Class](notation/state/state-9.png)

Illustration: Composite State

![Class](notation/state/state-10.png)

Transition to a compisite state always invokes the first sub state unless specified. A history vertex enables transition to the last active state, instead.

![Class](notation/state/state-11.png)

A substatemachine is a re-usable unit like procedure.

![Class](notation/state/state-8.png)

An orthogonal state is a composite state with parallel transitions.

![Class](notation/state/state-7.png)

Illustration: Orthogonal state

![Class](notation/state/state-12.png)

### 2.4. Sequence Diagram ###
Represents interactions among objects in a specific scenario.

#### 2.4.1. Lifeline ####
Represents an active object

![Class](notation/sequences/sequence-1.png)

#### 2.4.2. Interactions ####
Objects make requests and receive responses from other objects.

![Class](notation/sequences/sequence-2.png)

Objects also create or destroy other objects.

![Class](notation/sequences/sequence-3.png)

An object may act up on a signal or send a signal.

![Class](notation/sequences/sequence-4.png)

Objects may post messages to other objects or invoke call backs. A state-invariant node may annotate a lifefline.

![Class](notation/sequences/sequence-6.png)

#### 2.4.3. Fragments ####

A request may be representated as a parameterized operation with optional assignments, conditions and iterations.

Several messages might be grouped together for clarity.

Interactions like opt (if), alt(if-else), parallel, critical, iter and etc., are also represented as combined fragments.

![Class](notation/sequences/sequence-7.png)