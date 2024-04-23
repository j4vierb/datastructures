import heapq

"""
V, E = map(int, input().split())
graph = {i : [] for i in range(0, V)}

for i in range(0, E):
    src, to, w = map(int, input().split())
    graph[src-1].append((to-1, w))

"""
V = 5
# (nodo, w)
graph = {0: [(1, 5), (2, 2), (3, 6)], 1: [], 2: [(3, 1), (4, 5)], 3: [], 4: []}

# apply dijkstra
dist = [float('inf') for _ in range(V)]
parent = [-1 for _ in range(V)]
visited = [False for _ in range(V)]

dist[0] = 0
pq = [(0, 0)]

while len(pq) != 0:
    u, dis = heapq.heappop(pq)
    
    if dis > dist[u]:
        continue
    
    for node in graph[u]:
        v, w = node
        distance = dis + w
        
        if distance < dist[v]:
            dist[v] = distance
            parent[v] = u
            heapq.heappush(pq, (v, distance))
    

for d in dist:
    if(d != 0):
        print(d, end=' ')
