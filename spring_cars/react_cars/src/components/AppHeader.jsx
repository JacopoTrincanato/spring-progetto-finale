import { NavLink } from 'react-router-dom'
export default function AppHeader() {

    return (
        <header>
            <nav className="navbar navbar-expand-lg">
                <div className="container-fluid">
                    <NavLink to='/' className="navbar-brand">TJ Cars</NavLink>
                    <div className="collapse navbar-collapse">
                        <ul className="navbar-nav ms-auto">
                            <li className="nav-item">
                                <NavLink to='/' className="nav-link">Cars</NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink to='/optionals' className="nav-link">Optionals</NavLink>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    )
}