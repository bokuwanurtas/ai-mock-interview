import './App.css'

const features = [
  { title: 'AI Interviews', description: 'Practice technical questions with an AI interviewer.' },
  { title: 'Company Preparation', description: 'Prepare for interviews at your target company.' },
  { title: 'Personalized Feedback', description: 'Find your strengths and the skills to improve.' },
]

export default function App() {
  return (
    <div className="app">
      <header className="header">
        <a className="logo" href="#home">AI Mock Interview</a>
        <nav aria-label="Main navigation">
          <a href="#features">Features</a>
          <a href="#about">About</a>
          <button type="button" className="login-btn" disabled title="Coming soon">Login</button>
        </nav>
      </header>

      <main id="home">
        <section className="hero">
          <span className="eyebrow">Practice smarter, interview confidently</span>
          <h1>Prepare for Your Next IT Interview</h1>
          <p>Practice technical interviews with AI, improve your skills, and get personalized feedback.</p>
          <a className="start-btn" href="#features">Explore features</a>
        </section>

        <section className="features" id="features">
          <h2>Everything you need to prepare</h2>
          <div className="cards">
            {features.map((feature) => (
              <article className="card" key={feature.title}>
                <h3>{feature.title}</h3>
                <p>{feature.description}</p>
              </article>
            ))}
          </div>
        </section>
      </main>

      <footer id="about">AI Mock Interview © 2026 · Diploma project</footer>
    </div>
  )
}
