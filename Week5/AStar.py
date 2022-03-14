from queue import PriorityQueue
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
        # South
        if self.map_data[location[0] + 1][location[1]] != "%":
            neighbors.append((location[0] + 1, location[1]))
        # East
        if self.map_data[location[0]][location[1] + 1] != "%":
            neighbors.append((location[0], location[1] + 1))
        # West
        if self.map_data[location[0]][location[1] - 1] != "%":
            neighbors.append((location[0], location[1] - 1))
        return neighbors

    @staticmethod
    def heuristics(location, goal_location):
        return abs(location[0] - goal_location[0]) + abs(location[1] - goal_location[1])


class AStarSearch(SearchFunction):

    def __init__(self):

        super().__init__()

    def search(self):
        visited = []
        frontier = PriorityQueue()
        frontier.put((0, self.start))
        came_from = {self.start: None}
        cost_so_far = {self.start: 0}

        while not frontier.empty():
            current_location = frontier.get()[1]
            if current_location == self.goal:
                break

            for neighbor in self.neighbor_locations(current_location):
                new_cost = cost_so_far[current_location] + 1
                if neighbor not in came_from or new_cost < cost_so_far[neighbor]:
                    visited.append(neighbor)
                    cost_so_far[neighbor] = new_cost
                    priority = new_cost + self.heuristics(neighbor, self.goal)
                    frontier.put((priority, neighbor))
                    came_from[neighbor] = current_location

        path = []
        current_location = self.goal
        while current_location != self.start:
            path.append(current_location)
            current_location = came_from[current_location]

        return path, visited


if __name__ == '__main__':
    a_star = AStarSearch()
    result_path, result_visited = a_star.search()

    print(str(len(result_path)))
    result_path.reverse()
    print(a_star.start[0], a_star.start[1])
    for a, b in result_path:
        print(a, b)
