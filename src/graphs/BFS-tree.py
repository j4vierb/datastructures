V = int(input())
graph = [[0 for _ in range(V)] for _ in range(V)]

for i in range(0, V-1):
    a, b = map(int, input().split(" "))
    graph[a-1][b-1] = 1
    graph[b-1][a-1] = 1

x = int(input())

# apply BFS
parents = [(-1, 1) for _ in range(V)]
visited = [False for _ in range(V)]

queue = []

queue.append(0)
visited[0] = True

nodes_level = 0

while len(queue) != 0:
    node = queue.pop(0)

    for adj, w in enumerate(graph[node]):
        if w != 0 and not visited[adj]:
            queue.append(adj)
            visited[adj] = True
            level = parents[node][1] + 1
            if level == x:
                nodes_level += 1
            parents[adj] = (node, level)

print(f"{nodes_level}")
