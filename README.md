# 🚀 Web Servers Under the Hood: From 50K to 1 Million RPS

## 📘 Overview  
This project is a deep dive into building high-performance web servers from scratch using **Java** and **Sockets** - without relying on frameworks. It explores what truly drives scalability and performance, taking a bottom-up approach grounded in **Operating Systems** and **Networking fundamentals**.

## 🎯 Goal  
To understand the architectural and system-level decisions that enable servers to handle massive traffic, bridging the gap between academic theory and real-world performance.

## ⚙️ Approach

### 🧵 Single-threaded Server  
- A baseline implementation to test raw throughput.  
- Achieved ~50,000 RPS.

### ⚙️ Multi-threaded Server  
- Introduced basic concurrency using one thread per request.  
- Scaled performance up to ~100,000 RPS.

### 🚀 Thread Pool Optimization  
- Implemented using Java’s `java.util.concurrent` package.  
- A carefully tuned thread pool (just 20 threads) reached **1 Million RPS** 🤯  
- Achieved this by minimizing context switching and maximizing CPU core utilization.

## 🧠 Key Learnings

- Deep understanding of **thread scheduling**, **context switching**, and **I/O handling**.
- Hands-on experience with Java concurrency utilities (`Executors`, `BlockingQueue`, etc.).
- Insight into performance bottlenecks and how architectural trade-offs affect system throughput.
- Reinforced the importance of low-level system knowledge—even when working with high-level frameworks.

## 💡 Takeaway  
Performance isn’t just about better frameworks—it's about understanding **why** things work. This project highlights how a solid grasp of system internals leads to smarter, scalable, and more efficient backend design.
