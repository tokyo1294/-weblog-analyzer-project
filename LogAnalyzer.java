
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    //question 5
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    //question 4
    public void printHourlyCounts()
    {
        int hours = 0;
        System.out.println("Hr: Count");
        while(hours < hourCounts.length) {
            System.out.println(hours + ": " + hourCounts[hours]);
            hours++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    //question 6
    public int numberOfAccesses() { 
int total = 0;
 for(int hour = 1; hour < hourCounts.length; hour++){
      total = total + hourCounts[hour]; 
    } 
    return total;
   }
   //question 8
   public int busiestHour(){
       int busiest = 0;
       for(int hour : hourCounts){
           if( hour > busiest){
               busiest = hour;
            }
        }
        return busiest;
    }
       
    //question 9
    public int quiestistHour(){
        int quiestist = 0;
        for (int hour =1; hour < hourCounts.length; hour++){
            if(hourCounts[hour] < hourCounts[quiestist]){
                 quiestist = hour;
            }
        }
        return  quiestist;
        }
    }
    
           
