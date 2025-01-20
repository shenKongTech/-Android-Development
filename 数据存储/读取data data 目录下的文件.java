public String readFile(String fileName) throws IOException
{
String res="";
try
{
FileInputStream stream=openFileInput(fileName);
int length=stream.available ();
byte data[]=new byte[length];
stream.read(data);
stream.close();
catch(IOException e)
{
e.printStackTrace();
}
}
return res;

}