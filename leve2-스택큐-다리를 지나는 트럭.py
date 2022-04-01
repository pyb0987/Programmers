def solution(bridge_length, weight, truck_weights):
    timeline, time = [], 0
    while(truck_weights):
        time+=1
        for i in range(time+bridge_length-len(timeline)):
            timeline.append([])
        if(truck_weights[0]+sum(timeline[time])<=weight):
            w=truck_weights.pop(0)
            for i in range(bridge_length):
                timeline[time+i].append(w)
    return len(timeline)
