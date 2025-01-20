public String readFileSdcardFile(String fileName) throws IOException
{
String res="";
try
{
FileInputStream stream=new FileInputStream(fileName);
int length=stream.available();
byte data[]=new byte[length];
stream.read(data);
stream.close();
}
catch(IOException e)
{
e.printStackTrace();
}
return res;
}