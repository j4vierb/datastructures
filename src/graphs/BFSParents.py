"""
Hallar el número de nodos (i, j) minimo sin caer en los huecos (-1) para llegar de un punto de inicio "source" a un punto de destino "dest" en una matriz de n x m.

Solución: La idea básica del algoritmo es hacer un recorrido BFS en la matriz e ir guardando el nodo predecesor de cada nodo marcado como visitado y el número de nodos que hay antes de llegar a él.
"""

def solution(matrix, src: tuple[int, int], dest: tuple[int, int]):
  rows, cols = len(matrix), len(matrix[0])
  visited = [[False for _ in range(cols)] for _ in range(rows)]
  parent = [[None for _ in range(cols)] for _ in range(rows)]
  
  queue = []
  
  queue.append(src)
  parent[src[0]][src[1]] = ((-1, -1), 0) # ( (parent_I, parent_J), distance)
  visited[src[0]][src[1]] = True
  
  while len(queue) != 0:
    node = queue.pop(0)
    i, j = node
    
    directions = [(i-1, j), (i, j-1), (i+1, j), (i, j+1)]
    for di, dj in directions:
      if 0 <= di < rows and 0 <= dj < cols and not visited[di][dj] and matrix[di][dj] != -1:
        queue.append( (di, dj) )
        visited[di][dj] = True
        parent[di][dj] = ( (i, j), parent[i][j][1] + 1)
            
  if parent[dest[0]][dest[1]] == None:
    return -1
  else:
    return parent[dest[0]][dest[1]] [1] # posición 1 tiene padre

source = (0,0)
dest = (2, 2)
matrix = [
  [1, -1, -1],
  [1, 1, -1],
  [1, 1, 1]
]

print(f"Min distance from {source} to {dest} is {solution(matrix, source, dest)}")
