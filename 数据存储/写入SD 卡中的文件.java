public void writeFileSdcardFile(String fileName,String writestr) throws IOException
{
try
{
FileOutputStream stream=new FileOutputStream(fileName);
byte data[]=writrstr.getBytes();
stream.write(data);
stream.close();
}
catch(IOException e)
{
e.printStrackTrace();
}
}