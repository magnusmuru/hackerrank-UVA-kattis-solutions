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
            int maximum = 0;
            for (List<Integer> query : test.Queries) {
                int upperBound = query.get(1);

                areaLoop:
                for (int height = 0; height < test.Area.size(); height++) {
                    List<Integer> row = test.Area.get(height);

                    for (int width = 0; width < row.size(); width++) {
                        int number = row.get(width);
                        if (number >= query.get(0) && number <= upperBound) {
                            maximum++;
                            int candidateHeight = height + 1;
                            int candidateWidth = width + 1;
                            
                            while (test.Height - 1 >= candidateHeight && test.Width - 1 >= candidateWidth) {
                                if (test.Area.get(candidateHeight).get(candidateWidth) <= upperBound) {
                                    candidateHeight++;
                                    candidateWidth++;
                                    maximum++;
                                } else {
                                    break;
                                }

                            }
                            break areaLoop;
                        }
                    }
                }
                output.add(String.valueOf(maximum));
                maximum = 0;
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
