import React from 'react'; 


function Post(props){
    return (
        <div className='post' onClick={props.onClick}>
            <h1>{props.id}</h1>
            <p>{props.title}</p>
            <p>{props.author}</p>
        </div>
    );
}

export default Post;