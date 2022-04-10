from ctypes import pointer


def solution(routes):
    routes.sort()
    pointer = 0 
    answer = 0
    n = len(routes)
    while(pointer<n ):
        endpoint = routes[pointer][1]
        pointer+=1
        while(pointer<n and endpoint>=routes[pointer][0]):
            endpoint=min(endpoint, routes[pointer][1])
            pointer+=1
        answer+=1
    print(routes)
    print(answer)
    return answer


solution([[-20,-15], [-14,-5], [-18,-12], [-14,-13],[-5,-3]])
solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]])