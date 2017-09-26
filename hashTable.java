public class hashTable {
	
	@SuppressWarnings("all")
	public hashTable(){
		this (TABLESIZE);
	}
	
	public hashTable(int size){
		makeArray(size);
		occupied = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
	}
	
	public boolean insert (String x){
		//changed insert to take only 1 string argument
		//if string already inside hash table
		int pos = findPos(x);
		if(isActive(pos)){
		    return false;
		}
		//if not inside
		//put it inside, mark as true, increment size
	    array[pos] = new HashEntry<>(x,true);
	    theSize++;
	    //if this pushes it over the max size, call rehash
	    if(++occupied > array.length/2){
	    	rehash(); 
	    }
	    return true;  
	}
	
	private void rehash(){
		HashEntry<String> [] oldArray = array;
		
		makeArray(2 * oldArray.length);
		occupied = 0;
		theSize = 0;
		
        for( HashEntry<String> entry : oldArray )
            if( entry != null && entry.isActive )
                insert( entry.element );
	}
	
	private int findPos( String x)
	{
		int offset = 1;
		int thisPos = myhash(x);
		
		while(array[thisPos]!=null &&
				!array[thisPos].element.equals(x)){
			thisPos += offset;
			offset += 2;
			if( thisPos >= array.length)
				thisPos -= array.length;
		}
		return thisPos;
	}
	
    public boolean contains( String x )
    {
        int thisPos = findPos( x );
        return isActive( thisPos );
    }
	
    private boolean isActive( int thisPos )
    {
        return array[ thisPos ] != null && array[ thisPos ].isActive;
    }

	
    private int myhash( String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;
        return hashVal;
    }
    

	@SuppressWarnings("hiding")
	private static class HashEntry<String>
    {
        public String  element;
        public boolean isActive;

		@SuppressWarnings("unused")
		public HashEntry( String e )
        {
            this( e, true );
        }

        public HashEntry( String e, boolean i )
        {
            element  = e;
            isActive = i;
        }
    }
    
    private static final int TABLESIZE = 100;
    private HashEntry<String> [ ] array;
    private int occupied;
    @SuppressWarnings("unused")
	private int theSize;
    
	@SuppressWarnings("unchecked")
	private void makeArray( int arraySize ) {
    	array = new HashEntry[ nextPrime( arraySize ) ];
    }
    
    private static int nextPrime( int n ){
        if( n % 2 == 0 )
            n++;
        for( ; !isPrime( n ); n += 2 ){}
        return n;
    }

    private static boolean isPrime( int n ){
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
    }
}