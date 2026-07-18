# 0735. Asteroid Collision

## 💡 My Approach
# LeetCode 735 - Asteroid Collision

## Pattern
**Monotonic Stack / Simulation**

---

## Key Observation

A collision occurs **only when**:

```text
Top of Stack → (+)
Current Asteroid ← (-)
```

Condition:

```java
st.peek() > 0 && ast < 0
```

These **never collide**:

```text
→ →
← ←
← →
```

Only

```text
→ ←
```

can collide.

---

## Stack Idea

- Stack stores all asteroids that have survived so far.
- Process each asteroid from left to right.
- Keep resolving collisions until:
  - current asteroid is destroyed, or
  - no collision is possible.

---

## Collision Cases

### Case 1: Stack asteroid is larger

```text
10   -5
```

```text
10 survives
-5 explodes
```

```java
if (st.peek() > -ast) {
    destroyed = true;
    break;
}
```

---

### Case 2: Both are equal

```text
8   -8
```

```text
Both explode
```

```java
else if (st.peek() == -ast) {
    st.pop();
    destroyed = true;
    break;
}
```

---

### Case 3: Current asteroid is larger

```text
5   -10
```

```text
5 explodes
-10 continues moving
```

```java
else {
    st.pop();
    // DON'T break
}
```

**Important:** Do **not** break here because the current asteroid may collide with more asteroids already in the stack.

Example:

```text
[3,5,-10]

5 dies
↓

[3,-10]

3 dies
↓

[-10]
```

---

## Algorithm

```text
For each asteroid:

    while collision possible:

        if stack asteroid bigger:
            current destroyed
            stop

        else if equal:
            destroy both
            stop

        else:
            pop stack asteroid
            continue checking

    if current survived:
        push into stack
```

---

## Common Mistakes

### ❌ Wrong collision condition

```java
st.peek() * ast < 0
```

This also matches:

```text
← →
```

which never collide.

Correct:

```java
st.peek() > 0 && ast < 0
```

---

### ❌ Breaking after popping

Wrong:

```java
st.pop();
break;
```

Correct:

```java
st.pop();
```

Reason:

The current asteroid is still alive and may collide again.

---

### ❌ Forgetting equal-size case

```text
8  -8
```

Both should disappear.

---

## Time Complexity

- Each asteroid is pushed at most once.
- Each asteroid is popped at most once.

**Time:** `O(n)`

**Space:** `O(n)`

---

# Template

```java
Stack<Integer> st = new Stack<>();

for (int ast : asteroids) {

    boolean destroyed = false;

    while (!st.isEmpty() && st.peek() > 0 && ast < 0) {

        if (st.peek() > -ast) {
            destroyed = true;
            break;
        }
        else if (st.peek() == -ast) {
            st.pop();
            destroyed = true;
            break;
        }
        else {
            st.pop();      // continue checking
        }
    }

    if (!destroyed)
        st.push(ast);
}
```

---

## Interview Takeaway

Whenever you see:

- Objects moving in opposite directions
- Repeated elimination/collision
- Need to process previous surviving elements

Think:

**Use a Stack to simulate the process**, where the stack always represents the current surviving state.

---

_Official problem description unavailable._