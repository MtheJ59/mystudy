import './App.css';
import { useState } from 'react';

function Header(props) {
	console.log('props', props, props.title);
	return (
		<header>
			<h1>
				<a
					href='/'
					onClick={(event) => {
						event.preventDefault(); //
						props.onChangeMode();
					}}
				>
					{props.title}
				</a>
			</h1>
		</header>
	);
}

function Nav(props) {
	const lis = [];
	for (let i = 0; i < props.topics.length; i++) {
		let t = props.topics[i];
		lis.push(
			<li key={t.id}>
				<a
					id={t.id}
					href={'/read/' + t.id}
					onClick={(event) => {
						event.preventDefault();
						props.onChangeMode(Number(event.target.id));
					}}
				>
					{t.title}
				</a>
			</li>
		);
	}
	return (
		<nav>
			<ol>{lis}</ol>
		</nav>
	);
}

function Article(props) {
	return (
		<article>
			<h2>{props.title}</h2>
			{props.body}
		</article>
	);
}

function Create(props) {
	return (
		<article>
			<h2>Create</h2>
			<form
				onSubmit={(event) => {
					event.preventDefault();
					const title = event.target.title.value;
					const body = event.target.body.value;
					props.onCreate(title, body);
				}}
			>
				<p>
					<input
						type='text'
						name='title'
						placeholder='title'
					/>
				</p>
				<p>
					<textarea
						name='body'
						placeholder='body'
					></textarea>
				</p>
				<p>
					<input
						type='submit'
						value='Create'
					></input>
				</p>
			</form>
		</article>
	);
}

function App() {
	// const _mode = useState('WELCOME'); //useState의 인자는 그 스테이트의 초기값이다.
	// const mode = _mode[0]; // 스테이트의 값은 0번째 값으로 읽는다.
	// const setMode = _mode[1]; // 스테이트를 바꿀 때는 1번째 인덱스 값으로 바꾼다.

	const [mode, setMode] = useState('WELCOME'); // 위 코드를 축약한 것
	const [id, setId] = useState(null);
	const [topics, setTopics] = ([
		{ id: 1, title: 'html', body: 'html is ...' },
		{ id: 2, title: 'css', body: 'css is ...' },
		{ id: 3, title: 'javascript', body: 'javascript is ...' },
	]);
	const [nextId, setNextId] = useState(4);


	let content = null;
	if (mode === 'WELCOME') {
		content = (
			<Article
				title='Welcome'
				body='Hello, Web'
			></Article>
		);
	} else if (mode === 'READ') {
		let title,
			body = null;
		for (let i = 0; i < topics.length; i++) {
			if (topics[i].id === id) {
				title = topics[i].title;
				body = topics[i].body;
			}
		}
		content = (
			<Article
				title={title}
				body={body}
			></Article>
		);
	} else if (mode === 'CREATE') {
		content = <Create onCreate={(_title, _body) => {
			const newTopic = {id:nextId, title:_title, body:_body}
			topics.push(newTopic);
			setTopics(topics);
		}}></Create>;
	}

	return (
		<div>
			<Header
				title='WEB'
				onChangeMode={() => {
					setMode('WELCOME');
				}}
			></Header>
			<Nav
				topics={topics}
				onChangeMode={(_id) => {
					setMode('READ');
					setId(_id);
				}}
			></Nav>
			{content}
			<a
				href='/create'
				onClick={(event) => {
					event.preventDefault();
					setMode('CREATE');
				}}
			>
				Create
			</a>
		</div>
	);
}

export default App;
