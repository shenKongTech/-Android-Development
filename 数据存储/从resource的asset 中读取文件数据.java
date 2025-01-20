String fileName="Test.txt"
try
{
InputStream stream=getResource().getAssets().open(fileName);
int length=stream.available ();
byte data[]=new byte[length];
stream.read(data);
stream.close();
}
catch(IOException e)
{
e.printStackTrace();
}