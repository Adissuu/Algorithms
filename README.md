# COMP-352 
# Question 1: 
a)

    input: Array of integer containing n elements
    Output: String of highest occurence of number in n

    String s <- ""
    counter <- 0
    best <- 0

    FOR i = 0 to array length - 1
        counter = 0
        FOR j = 0 to array length - 1
            IF (n[i] == n[j]) THEN
                counter INCREMENT
    
        IF (best == counter THEN
            s <-     "," + n[i]
        IF (counter > best) THEN
            s <- n[i]
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
                swap(A[j], A[j + 1]) -> 3
                done ← false -> 1
            j ← j + 1 -> 1
        end while
        j ← n - 1 -> 1
        while j ≥ 1 do -> n 
            if A[j] < A[j - 1] then -> 1
                swap(A[j - 1], A[j]) -> 3
                done ← false -> 1
            j ← j - 1 -> 1
        end while
    if ¬ done -> 
        MyAlgorithm(A, n) -> n
    else
        return A -> 1

f(n) = 15n + 2

f(n) = O(n) (c=15 n0 = 2 ) Since O(n) is always bigger than f(n) if 15 ≤ C and 2 ≤ n

f(n) = Ω(n) (c = 15 n0 = 0) Because there is no possibility that the function Omega might be bigger at any point since f(n) is always bigger than 15n.   

b) 
    
    j = 0
    A{24,20,51,4,37}
    -> 0 =< 5 - 2 -true
        A[0] > A[1] -true
        A{20,24,51,4,37} 
        done -false
    -> 1 =< 5 - 2 -true
        A[1] > A[2] -false
        A{20,24,51,4,37}
    -> 2 =< 5 - 2 -true
        A[2] > A[3] -true
        A{20,24,4,51,37}
    -> 3 =< 5 - 2 -true
        A[3] > A[4] -true
        A{20,24,4,37,51}
    j = 4
    -> 4 => 1 -true
        A[4] < A[3] -false
        A{20,24,4,37,51}
    -> 3 => 1 -true
        A[3] < A[2] -false
        A{20,24,4,37,51}
    -> 2 => 1 -true
        A[2] < A[1] -true
        A{20,4,24,37,51}
    -> 1 => 1 -true
        A[1] < A[0] -true
        A{4,20,24,37,51}

    done == true -false

    MyAlgorithm(A,n)
    done -true 
    return A
    
c) It sorts the array in ascending order.

d) 
    Yes, by using bubble sort. This way, instead of doing two loop, we do one:
    FOR i < n - 1
        IF n[i] > n[i+1] THEN
            swap(A[i], A[i + 1])
    MyAlgorithm(A, n-1)

e) Direct recursion. It is not tail recursive since the function does not return the recursion.

________________________________________________