from queue import Queue
import os
import sys


class SearchFunction:

    def __init__(self):
        self.start = tuple(map(int, input().split()))
        self.goal = tuple(map(int, input().split()))
        self.size = tuple(map(int, input().split()))
        self.map_data = sys.stdin.readlines()

    def neighbor_locations(self, location: tuple):
        neighbors = []
        # North
        if self.map_data[location[0] - 1][location[1]] != "%":
            neighbors.append((location[0] - 1, location[1]))
        # West
        if self.map_data[location[0]][location[1] - 1] != "%":
            neighbors.append((location[0], location[1] - 1))
        # East
        if self.map_data[location[0]][location[1] + 1] != "%":
            neighbors.append((location[0], location[1] + 1))
        # South
        if self.map_data[location[0] + 1][location[1]] != "%":
            neighbors.append((location[0] + 1, location[1]))
        return neighbors

    @staticmethod
    def heuristics(location, goal_location):
        return abs(location[0] - goal_location[0]) + abs(location[1] - goal_location[1])


class BFS(SearchFunction):

    def __init__(self):

        super().__init__()

    def search(self):
        visited = []
        frontier = Queue()
        frontier.put(self.start)
        came_from = {self.start: None}

        while not frontier.empty():
            current_location = frontier.get()
            if current_location == self.goal:
                break

            for neighbor in self.neighbor_locations(current_location):
                if neighbor not in came_from:
                    visited.append(neighbor)
                    frontier.put(neighbor)
                    came_from[neighbor] = current_location

        current_location = self.goal
        path = []
        while current_location != self.start:
            path.append(current_location)
            current_location = came_from[current_location]

        return path, visited


if __name__ == '__main__':
    bfs = BFS()
    result_path, result_visited = bfs.search()

    index = result_visited.index((bfs.goal[0], bfs.goal[1]))

    print(str(index + 2))
    print(bfs.start[0], bfs.start[1])
    for a, b in result_visited[:index + 1]:
        print(a, b)

    result_path.reverse()
    print(str(len(result_path)))
    print(bfs.start[0], bfs.start[1])
    for a, b in result_path:
        print(a, b)
