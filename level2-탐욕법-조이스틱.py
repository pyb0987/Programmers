def solution(name):
    n = len(name)
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    Acheck = [1 if name[i%n]!='A' else 0 for i in range(1,n*2)]
    if len(Acheck)==1 or 1 not in Acheck:
        cursor = 0
    else: 
        cursor = n
        for i in range(0,n):
            left = Acheck[i:n-1]
            right = Acheck[n:i+n]
            leftgo = 0 if 1 not in left else len(left)-left.index(1) 
            rightgo = 0 if 1 not in right else len(right)-right[::-1].index(1)
            cursor = min(cursor, 2*leftgo+rightgo, 2*rightgo+leftgo)
    lettertype = [min(alphabet.index(letter), 26-alphabet.index(letter)) for letter in name]
    answer=cursor+sum(lettertype)
    return answer


solution("ABBAAAAAB")