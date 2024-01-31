import React, { useState, useEffect } from 'react';
import Posts from '../components/Posts';
import PostDetail from '../components/PostDetail'
import axios from 'axios';

const Dashboard = () => {
    const [posts, setPosts] = useState([
        { id: 1, title: "Post 1", content: "This is the content of Post 1" },
        { id: 2, title: "Post 2", content: "This is the content of Post 2" },
        { id: 3, title: "Post 3", content: "This is the content of Post 3" },
    ]);

    const [newTitle, setNewTitle] = useState('');
    const [selectPost, setSelectPost] = useState(posts[0])

    const handleTitleChange = (event) => {
        setNewTitle(event.target.value);
    };

    useEffect(()=>{
        axios.get('http://localhost:8080/api/v1/posts')
        .then(response => {
            setPosts(response.data)
        })
        .catch(error => console.log(error))
    },[]);

    const handlePostClick = (post) =>{
        setSelectPost(post);
    }

    const handleChangeFirstPost = () => {
        const updatedPosts = [...posts];
        updatedPosts[0].title = newTitle;
        setPosts(updatedPosts);
    };

    return (
        <div>
            <h1>Dashboard</h1>
            <input type="text" value={newTitle} onChange={handleTitleChange} />
            <button onClick={handleChangeFirstPost}>Update Title</button>
            <Posts posts={posts}  onPostClick = {handlePostClick}/>
            <PostDetail post={selectPost} ></PostDetail>
        </div>
    );
};

export default Dashboard;