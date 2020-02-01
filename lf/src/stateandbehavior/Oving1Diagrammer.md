# Diagrammer for Øving 1
Dette er eksempeldiagrammer for øving 1. Merk at man står fri til å velge kall-sekvenser selv, så dette er bare eksempler og ikke eneste fasit.

## Account
```plantuml
@startuml
object "~#1: Account" as a1 {
    balance = 0
    interestRate = 0
}
object "~#1: Account" as a2 {
    balance = 0
    interestRate = 5
}
object "~#1: Account" as a3 {
    balance = 1000
    interestRate = 5
}
object "~#1: Account" as a4 {
    balance = 1050
    interestRate = 5
}

a1 ..> a2: setInterestRate(5)
a2 ..> a3: deposit(1000)
a3 ..> a4: addInterest()

@enduml
```

## Location
```plantuml
@startuml
object "~#1: Location" as l1 {
    x = 0
    y = 0
}
object "~#1: Location" as l2 {
    x = 1
    y = 0
}
object "~#1: Location" as l3 {
    x = 1
    y = -1
}
object "~#1: Location" as l4 {
    x = 0
    y = -1
}
object "~#1: Location" as l5 {
    x = 0
    y = 0
}

l1 ..> l2: right()
l2 ..> l3: up()
l3 ..> l4: left()
l4 ..> l5: down()
@enduml
```

## Digit
```plantuml
@startuml
object "~#1: Digit" as d1 {
    base = 3
    value = 0
}
object "~#1: Digit" as d2 {
    base = 3
    value = 1
}
object "~#1: Digit" as d3 {
    base = 3
    value = 2
}
object "~#1: Digit" as d4 {
    base = 3
    value = 0
}

d1 ..> d2: increment() => false
d2 ..> d3: increment() => false
d3 ..> d4: increment() => true
@enduml
```

## Rectangle

```plantuml
@startuml
object "~#1: Rectangle" as r1 {
    x = 0
    y = 0
    width = 0
    height = 0
}
object "~#1: Rectangle" as r2 {
    x = 3
    y = 2
    width = 1
    height = 1
}
object "~#1: Rectangle" as r3 {
    x = 1
    y = 2
    width = 3
    height = 4
}

object "r2: Rectangle" as other {
    x = -1
    y = 4
    width = 1
    height = 3
}

object "~#1: Rectangle" as r4 {
    x = -1
    y = 2
    width = 5
    height = 5
}

r1 ..> r1: isEmpty() => true
r1 ..> r2: add(3, 2)
r2 ..> r3: add(1, 5)
r3 ..> r4: add(r2)
r3 ..> r3: "getMinX() => 1\ngetMaxX() => 3\ngetMinY() => 2\ngetMaxY() => 5"
r3 -[hidden]> other
@enduml
```

## LineEditor

```plantuml
@startuml
object "l1: LineEditor" as l1 {
    text = ""
    insertionIndex = 0
}
object "l1: LineEditor" as l2 {
    text = "hei"
    insertionIndex = 3
}
object "l1: LineEditor" as l3 {
    text = "hei"
    insertionIndex = 2
}
object "l1: LineEditor" as l4 {
    text = "hi"
    insertionIndex = 1
}
object "l1: LineEditor" as l5 {
    text = "h"
    insertionIndex = 1
}
object "l1: LineEditor" as l6 {
    text = "Hello Word"
    insertionIndex = 2
}
object "l1: LineEditor" as l7 {
    text = "Hello Word"
    insertionIndex = 9
}
object "l1: LineEditor" as l8 {
    text = "Hello World"
    insertionIndex = 10
}

l1 ..> l2: insertString("hei")
l2 ..> l2: right()
l2 ..> l3: left()
l3 ..> l4: deleteLeft()
l4 ..> l5: deleteRight()
l5 ..> l6: setText("Hello Word")
l6 ..> l7: setInsertionIndex(9)
l7 ..> l8: insertString("l")
@enduml
```

## Stopwatch

```plantuml
@startuml
object "sw: StopWatch" as s1 {
    ticks = 0
    startTime = -1
    stopTime = -1
    lapStartTime = -1
    lapTime = -1
}
object "sw: StopWatch" as s2 {
    ticks = 0
    startTime = 0
    stopTime = -1
    lapStartTime = 0
    lapTime = -1
}
object "sw: StopWatch" as s3 {
    ticks = 500
    startTime = 0
    stopTime = -1
    lapStartTime = 0
    lapTime = -1
}
object "sw: StopWatch" as s4 {
    ticks = 500
    startTime = 0
    stopTime = -1
    lapStartTime = 500
    lapTime = 500
}
object "sw: StopWatch" as s5 {
    ticks = 750
    startTime = 0
    stopTime = -1
    lapStartTime = 500
    lapTime = 500
}
object "sw: StopWatch" as s6 {
    ticks = 750
    startTime = 0
    stopTime = 750
    lapStartTime = 750
    lapTime = 250
}

s1 ..> s2: start()
s2 ..> s3: tick(500)
s3 ..> s4: lap()
s4 ..> s5: tick(250)
s5 ..> s6: stop()
@enduml
```