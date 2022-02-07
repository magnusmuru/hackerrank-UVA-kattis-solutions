import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    void Begin() {
        Scanner scanner = new Scanner(System.in);

        boolean queryProgress = false;
        boolean problemProgress = false;
        List<Problem> Problems = new ArrayList<>();
        Problem newProblem = new Problem();
        int areaCount = 0;
        int queryCount = 0;


        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            if (str.equals("0 0")) {
                break;
            }

            if (queryProgress && queryCount == newProblem.QueryCount) {
                Problems.add(newProblem);
                newProblem = new Problem();
                areaCount = 0;
                queryCount = 0;
                problemProgress = false;
                queryProgress = false;
            }


            if (queryProgress && queryCount < newProblem.QueryCount) {
                queryCount++;
                List<Integer> queryRow = new ArrayList<>();
                String[] split = str.split(" ");

                for (String s : split) {
                    queryRow.add(Integer.valueOf(s));
                }
                newProblem.Queries.add(queryRow);
            }


            if (!queryProgress && problemProgress && areaCount == newProblem.Height) {
                newProblem.QueryCount = Integer.parseInt(str);
                queryProgress = true;
            }

            if (problemProgress && areaCount < newProblem.Height) {
                areaCount++;
                List<Integer> row = new ArrayList<>();
                String[] split = str.split(" ");

                for (String s : split) {
                    row.add(Integer.parseInt(s));
                }
                newProblem.Area.add(row);
            }

            if (!problemProgress) {
                String[] split = str.split(" ");
                newProblem = new Problem();
                newProblem.Height = Integer.parseInt(split[0]);
                newProblem.Width = Integer.parseInt(split[1]);
                problemProgress = true;
            }
        }
        Problems.add(newProblem);
        scanner.close();

        List<String> output = new ArrayList<>();

        for (Problem test : Problems) {
            Integer lowerBound = null;
            int maximum = 0;
            int lowerBoundHeight = 0;
            int lowerBoundWidth = 0;
            int currentHeight = -1;
            int currentWidth = -1;
            for (List<Integer> query : test.Queries) {
                int upperBound = query.get(1);
                for (List<Integer> row : test.Area) {
                    currentHeight++;
                    for (Integer number : row) {
                        currentWidth++;
                        if (lowerBound == null) {
                            if (number >= query.get(0) && number <= upperBound) {
                                lowerBound = number;
                                lowerBoundHeight = currentHeight;
                                lowerBoundWidth = currentWidth;
                            }
                        } else {
                            int widthDiff = currentWidth - lowerBoundWidth + 1;
                            int heightDiff = currentHeight - lowerBoundHeight + 1;
                            if (heightDiff == widthDiff && widthDiff > maximum) {
                                if (number >= lowerBound && number <= upperBound) {
                                        maximum = currentWidth - lowerBoundWidth + 1;
                                }
                            }

                        }
                    }
                    currentWidth = -1;
                }
                if (lowerBound != null && maximum == 0 && lowerBound.equals(query.get(0))) {
                    maximum = 1;
                }
                currentHeight = -1;
                output.add(String.valueOf(maximum));
                maximum = 0;
                lowerBound = null;
                lowerBoundHeight = 0;
                lowerBoundWidth = 0;
            }
            output.add("-");
        }

        for (String item : output) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Main myWork = new Main();
        myWork.Begin();
    }
}

class Problem {
    public int Height = 0;
    public int Width = 0;
    public int QueryCount = 0;
    public List<List<Integer>> Area = new ArrayList<>();
    public List<List<Integer>> Queries = new ArrayList<>();
}