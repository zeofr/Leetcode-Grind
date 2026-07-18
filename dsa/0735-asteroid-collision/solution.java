            }
                    st.pop();
                }
                    destroyed = true;
                    break;
                else{
                    st.pop();
                }
            if(!destroyed){
                st.push(ast);
            }

        }

        int res[] = new int[st.size()];

        for(int i = st.size()-1; i >= 0; i--){
                else if( st.peek() == -ast ){
                }
                    break;
                    destroyed = true;
                if( st.peek() > -ast){

            while(!st.isEmpty() && st.peek() > 0 && ast < 0){

            boolean destroyed = false;
            
        for(int ast : asteroids){
            res[i] = st.pop();
