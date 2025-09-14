

# 🚀 Java Concurrency, Multithreading & Functional Programming Examples

## 📌 Overview

This repository is a **collection of hands-on examples and mini-projects** demonstrating:

* Java concurrency & multithreading
* Synchronization, locks, and deadlock handling
* Thread pools & executors
* CompletableFuture & asynchronous programming
* Optionals, Streams, Functional Interfaces
* Generics & custom data structures
* File I/O and serialization

The goal is to build strong intuition for **writing correct, safe, and modern Java code** — the kind expected from top engineers in interviews and production.

---

## 📂 Repository Structure

```
.
├── AlarmClock/                  # Event loop & alarm scheduling
├── BankAccount/                 # Thread-safety & race conditions
├── ComparatorEx/                # Comparator and sorting examples
├── CompletableFuture/           # CompletableFuture demos
├── CustomStack/                 # Generic stack (thread-safe + Optionals)
├── Optionals/                   # Usage of Optional<T>
├── StreamAPI/                   # Streams, map/filter/reduce
├── StudentDB/                   # Mini project: Generics + Optionals + Streams
├── DeadLockDemo.java            # Deadlock demo
├── ExplicitLockDemo.java        # ReentrantLock example
├── FutureExample.java           # Future vs CompletableFuture
├── LockDemo.java                 # Lock basics
├── ProducerConsumer.java        # wait/notify & inter-thread communication
├── ThreadPoolDemo.java          # Fixed thread pool
├── SyncDemo.java                # synchronized keyword demo
├── FileCopyDemo.java            # Byte streams
├── CopyTextFile.java            # Character streams
├── students.ser                 # Serialized StudentDB example
└── README.md
```

---

## 🔑 Key Topics Covered

### 1. Concurrency & Threading

* **Creating Threads**: `Thread`, `Runnable`, `ExecutorService`
* **Thread pools**: `newFixedThreadPool`, `submit()`
* **Thread-safety**: `synchronized`, `ReentrantLock`
* **Deadlock & prevention**: `DeadLockDemo`, `ExplicitLockDemo`
* **Producer-Consumer**: wait/notify with shared queue
* **Sync vs Async**: Future, CompletableFuture

### 2. Asynchronous Programming

* `Future` vs `CompletableFuture`
* Chaining async tasks: `thenApply`, `thenCompose`
* Running tasks in parallel to reduce total execution time
* Error handling with `exceptionally`

### 3. Java Functional Programming

* **Optionals**: Safe null handling (`ifPresent`, `orElse`, `map`)
* **Streams API**:

  * Filtering, mapping, reducing
  * Collectors: `toList()`, `toSet()`, `toMap()`
  * Parallel streams
* **Functional Interfaces**: `Supplier`, `Consumer`, `Predicate`, custom interfaces
* **Comparator with lambdas**: Sorting objects cleanly

### 4. Collections & Generics

* Implementing a **Custom Generic Stack**

  * Push, pop, peek, search
  * Uses **ArrayList**
  * Returns **Optionals** for safety
  * Thread-safe with `synchronized`
* `StudentDB` mini project

  * Store students in a collection
  * Filter with custom predicates
  * Sort with comparator
  * Find top scorer with `Optional`

### 5. File I/O & Serialization

* File copy with **byte streams** (`FileInputStream`, `FileOutputStream`)
* Text file copy with **character streams**
* **Object serialization** with `ObjectOutputStream` / `ObjectInputStream`
* Custom serialization using `transient` + `writeObject`/`readObject`

### 6. Mini Projects

* **Alarm Clock**: Event loop, scheduling alarms
* **Bank Account**: Demonstrates race conditions, locking, and thread safety
* **StudentDB**: Combines streams, generics, Optionals, comparator, and serialization
* **CustomStack**: Thread-safe generic stack with Optionals

---

## 🛠 How to Run

### Clone repo

```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
```

### Compile & run any example

```bash
javac ThreadPoolDemo.java
java ThreadPoolDemo
```

Or using Maven (if project is Maven-enabled):

```bash
mvn exec:java -Dexec.mainClass="com.demo.ThreadPoolDemo"
```

---

## 📘 Learning Journey Recap

* Started with **basic threading** (`Thread`, `Runnable`)
* Explored **synchronization and locks**
* Learned **Producer-Consumer problem** with wait/notify
* Extended to **Thread Pools** for scalability
* Adopted **CompletableFuture** for async programming
* Practiced **Optionals, Streams, Comparator, Functional Interfaces**
* Built **mini-projects** (Alarm Clock, Bank Account, StudentDB, CustomStack) to apply concepts

---

## 💡 Interview Insights

* Be ready to explain **why synchronization is needed** and what race conditions look like.
* Discuss **thread pools vs one thread per client** (scalability, performance).
* Show **CompletableFuture** reduces response time by running tasks in parallel.
* Demonstrate **Optionals** avoid null checks and make APIs safer.
* Use **Streams + Functional Interfaces** to show clean, modern Java style.
* For **deadlock**, know both how to cause it and how to prevent it (lock ordering, `tryLock`).

---

## 🔮 Future Enhancements

* Add **multi-threaded socket server** (network concurrency)
* Implement **parallel file processing** with streams
* Add **unit tests** for concurrency safety
* Explore **Java NIO** (non-blocking I/O) for high-performance servers

---

✨ With this repo, I’ve covered the **practical concurrency toolkit** in Java, along with modern functional style coding. It’s both a **learning lab** and a **reference repo** for interviews and real projects.

---
