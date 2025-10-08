package Commands;

import MVC.Model;

public class GeneratePixelCodeCommand implements Command{
    private final Model model;
    private final String arrayName;

    public GeneratePixelCodeCommand(Model model, String arrayName) {
        this.model = model;
        this.arrayName = arrayName;
    }

    @Override
    public void execute() {
        boolean[][] pixels = model.getPixels();
        int rows = model.getSize();
        int cols = model.getSize();

        StringBuilder sb = new StringBuilder();
        sb.append("int[][] ").append(arrayName).append(" = {\n");

        for (int r = 0; r < rows; r++) {
            sb.append("    {");
            for (int c = 0; c < cols; c++) {
                sb.append(pixels[r][c] ? "1" : "0");
                if (c < cols - 1) sb.append(", ");
            }
            sb.append("}");
            if (r < rows - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("};");

        System.out.println(sb);
    }

    public String getArrayName() {
        return arrayName;
    }
}
