# COMP-352 
# Question 1: 
a)

    input: Array of integer containing n elements
    Output: String of highest occurence of number in n

    String s <- ""
    counter <-
    best <-

    for (int i = 0; i < n.lenght; i++)
        counter = 0
        for (int j = i; j < n.lenght; j++)
            if (n[i] == n[j]) 
                counter++
    
        if (best == counter)
            s += "," + n[i]
        if (counter > best)
            s = n[i]
            best <- counter
    print s

b) f(n) = O(n^2)

c) f(n) = O(n)

________________________________________________

# Question 2

a) 4n^3 + 250n^2 + 752n + 1000000 is Ω(n)

    True since the least this function can be when n goes to infinity
    is n^3, and since Ω(n^3) is included in Ω(n).

b) 99000n^3 + 8n^3 logn is Θ(log n)

    False, Theta functions are defined by the worst case, which is Big-O. 
    Big-O being O(n^3).

c) n^0.8 + logn is O(logn)

    True, as n goes to infinity, the function goes to logn.

d)  3n^4 + 8n^3logn is Θ(n^3logn)

    False, as n goes to infinity, the function goes to n^4 (n^4 > n^3logn, since n > logn).

e)  2nlog^2(n) + 6n^2nlog(n) is O(logn)

    False, it is O(n^2logn)

f)  n^6 + 0.0000001n^5 is Ω(n^5)

    True since the least it can get is n^5
________________________________________________

# Question 3

a)

    Algorithm MyAlgorithm(A, n)
    Input: Array of integer containing n elements
    Output: Possibly modified Array A
        done ← true -> 1
        j ← 0 -> 1
        while j ≤ n - 2 do -> (n - 1)
            if A[j] > A[j + 1] then -> 1
                swap(A[j], A[j + 1]) -> 1
                done ← false -> 1
            j ← j + 1 -> 1
        end while
        j ← n - 1 -> 1
        while j ≥ 1 do -> n 
            if A[j] < A[j - 1] then -> 1
                swap(A[j - 1], A[j]) -> 1
                done ← false -> 1
            j ← j - 1 -> 1
        end while
    if ¬ done -> 
        MyAlgorithm(A, n) -> n
    else
        return A -> 1

f(n) = 2n + 11

f(n) = O(n) (c=4 n0 = 6 ) Since O(n) is always bigger than f(n) if 4 ≤ C and 6 ≤ n

f(n) = Ω(n) (c = 2 n0 = 0) Because there is no possibility that the function Omega might be bigger at any point since f(n) is always bigger than 2n by 11.   

b) 
    
    | Done | j | n | j ≤ n - 2 | j ≥ 1 | A[j] > A[j + 1] (and later) A[j] < A[j - 1]|       A[]       | Output |
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    | true |   | 5 |           |       |                                            | (24,20,51,4,37) |        | 
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      | 0 | 5 |           |       |                                            | (24,20,51,4,37) |        | 
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      |   | 5 |   true    |       |                                            | (24,20,51,4,37) |        | 
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      |   | 5 |           |       |                 false                      | (24,20,51,4,37) |        | 
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      | 1 | 5 |           |       |                                            | (24,20,51,4,37) |        |
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      |   | 5 |   true    |       |                                            | (24,20,51,4,37) |        |
    |------|---|---|-----------|-------|--------------------------------------------|-----------------|--------|
    |      |   | 5 |           |       |                 true                       | (24,20,51,4,37) |        |    
c)

d)

e)

________________________________________________