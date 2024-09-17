package Recursion_Practice;

//Place tiles of Sizes 1*m in floor of Size n*m
// O[2^n]
public class Recursion12 
{
    public static int PlaceTiles(int n, int m)
    {
        if(n == m) // Base Case 1
        {
            return 2;
        }

        if(n<m) // Bsae Case 2
        {
            return 1;
        }

        // Vertically places
        int VertPlacements = PlaceTiles(n-m, m);
        //Horizantally place
        int HoriPlacements = PlaceTiles(n-1, m);

        return VertPlacements + HoriPlacements;
    }
    public static void main(String[] args) 
    {
        int n = 4, m = 2; 

        System.out.println(PlaceTiles(n, m));
    }
}
