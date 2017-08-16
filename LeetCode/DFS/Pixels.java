void floodFill(Color[][] image, int x, int y, Color fillColor) {
        if (immages == null ) return null;
        dfs(image, x, y, fillColor);
}

private void dfs(Color[][] image, int x, int y, Color fillColor) {
    Color orgionalColor = image[x][y];
    image[x][y] = fillColor;
    if (y + 1 <= image.length && image[x][y+1] == origionalColor) dfs(image, x, y + 1, fillColor);
    if (x + 1 <= image[0].length && image[x+1][y]== origionalColor) dfs(image, x + 1, y, fillColor);
    if (x - 1 >= 0 && image[x-1][y]== origionalColor) dfs(image, x - 1, y, fillColor);
    if (y - 1 >= 0 && image[x][y-1]== origionalColor) dfs(image, x, y - 1, fillColor);
}  


image = [ [......]
           [



int test[10];
x = 9
test[x+1];

test[10];
