def solution(numbers, target):
    sols = [0]
    for number in numbers:
        sols = [sol+number for sol in sols]+[sol-number for sol in sols]
    return sols.count(target)

print(solution([1, 1, 1, 1, 1],	3))