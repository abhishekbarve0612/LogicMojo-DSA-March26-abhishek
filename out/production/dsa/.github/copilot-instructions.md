---
name: dsa-syntax-assistance
description: "Guidelines for assisting with DSA problems: provide syntax completion and correction only, do not solve problems or complete core logic"
---

# DSA Problem Assistance Rules

When working on Data Structures and Algorithms problems in this workspace:

- **Syntax Only**: Stick to syntax completion and syntax correction. Do not complete the logic of the problem.
- **No Problem Solving**: Do not solve the question or provide the core algorithmic logic.
- **Test Cases and Output**: You may complete test cases or output sections, but not the core logic implementation.

These rules ensure that the learning process focuses on understanding and implementing solutions independently.

---

# New Solution.java — Initial Scaffold

When a `Solution.java` file is created or is blank, populate it with the following structure. Adapt return types, parameter names, and the `test()` helper to match the specific problem, but keep the overall shape identical.

```java
// Problem statement (copy from the problem)
// Include sample input and output
// Keep to 4-5 lines

import java.util.*;

class Solution {

    public <ReturnType> solve(int[] arr) {
        // student fills this in
    }

    public static void test(Solution solution, int[] arr, <ExpectedType> expected, String testName) {
        <ReturnType> result = solution.solve(arr);
        System.out.println(testName + ": arr = " + Arrays.toString(arr));
        System.out.println("Expected : " + <format expected>);
        System.out.println("Output   : " + <format result>);

        boolean passed = <comparison between result and expected>;
        System.out.println("Status   : " + (passed ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test cases go here (see rules below)
    }
}
```

---

# Test Case Writing Rules

Follow these rules strictly when adding or updating test cases in `main()`:

1. **Base expected values on the problem definition, not on what the current `solve()` returns.**
   The whole point of the test is to check whether the code is correct — not to confirm what it already does.
   If the code is buggy, the test must FAIL. Never adjust expected values to make a failing test pass.

2. **Do not touch `solve()`** when asked to add or update test cases.

3. **Max 5 test cases**: 1 basic/happy-path case + a few meaningful edge cases.

4. **No comments inside `main()`**. Keep test calls clean and minimal, like:
   ```java
   test(solution, new int[]{1, 2, 1, 2}, new int[]{0, 3, 4}, "Test 1 (basic)");
   test(solution, new int[]{7},          new int[]{-1, -1, 0}, "Test 2 (single element)");
   ```

5. **Derive expected values by hand** from the problem statement for each input. Trace through what the correct answer should be, independently of any code.

6. **Choose edge cases that stress the logic**, for example:
   - Empty or single-element arrays
   - All elements the same (e.g. all odd, all even, all zeros)
   - The correct answer window does not start at index 0
   - The full array is the answer

7. **Match the output format** (field labels, spacing) to whatever the `test()` helper already prints. Do not change the helper.
