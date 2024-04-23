# Dijkstra without PQ
V, E = map(int, input().split())
graph = {i : [] for i in range(0, V)}

for i in range(0, E):
    src, to, w = map(int, input().split())
    graph[src-1].append((to-1, w))


# apply dijkstra
dist = [float('inf') for _ in range(V)]
parent = [-1 for _ in range(V)]
spt = [False for _ in range(V)]

dist[0] = 0

def minDistance(dist, spt):
    m = -float('inf')
    min_index = -1

    for v in range(len(dist) - 1):
        if dist[v] < m and spt[v] == False:
            m = dist[v]
            min_index = v 

    return min_index

for count in range(V-1):
    u = minDistance(dist, spt)
    spt[u] = True

    for node in graph[u]:
        v, w = node
        distance = dist[u] + w
        if spt[v] != False and distance < dist[v]:
            dist[v] = distance
            parent[v] = u 

for d in dist:
    if(d != 0):
        print(d, end=' ')

