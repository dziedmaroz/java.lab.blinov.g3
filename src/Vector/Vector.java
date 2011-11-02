package Vector;


import VectorExceptions.VectorDimentionException;
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucian
 */

public class Vector
{
    double _vec [];
    int _dimetion;

    public  Vector (Vector vector)
    {
        _vec = new double [vector._dimetion];
        _dimetion = vector._dimetion;
        _vec = Arrays.copyOf(vector._vec, _dimetion);
    }
    public Vector(int dimetion)
    {
        this._dimetion = dimetion;
        this._vec = new double [_dimetion];
    }
    public Vector(double[] _vec)
    {
        this._vec = _vec;
        this._dimetion = _vec.length;
    }

    public int getDimetion()
    {
        return _dimetion;
    }

    public double[] getVec()
    {
        return _vec;
    }

    public void setDimetion(int _dimetion)
    {
        double _tmp[] = new double [this._dimetion];
        _tmp = Arrays.copyOf(this._vec,_dimetion<this._dimetion?_dimetion:this._dimetion);
        _vec = new double [_dimetion];
        _tmp = Arrays.copyOf(_tmp, _tmp.length);
        this._dimetion = _dimetion;
    }

    public void setVec(double[] _vec)
    {
        this._vec = _vec;
        this._dimetion = _vec.length;
    }

    public void setCoodrinate (double val, int index) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            _vec[index]=val;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw (e);
        }
    }

    public double getCoordinate (int index) throws ArrayIndexOutOfBoundsException
    {
        double tmp = 0;
        try
        {
            tmp = _vec[index];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw (e);
        }
        return tmp;
    }

    public Vector summ (Vector vector) throws VectorDimentionException
    {
        if (vector.getDimetion()!=this._dimetion)
        {
            throw (new VectorDimentionException ("Vectors have different dimentions"));
        }
        Vector tmp = new Vector(this);
        for (int i=0;i<_dimetion;i++)
        {
            tmp._vec[i]+=vector._vec[i];
        }
        return tmp;
    }
    public Vector diff (Vector vector) throws VectorDimentionException
    {
        if (vector.getDimetion()!=this._dimetion)
        {
            throw (new VectorDimentionException ("Vectors have different dimentions"));
        }
        Vector tmp = new Vector(this);
        for (int i=0;i<_dimetion;i++)
        {
            tmp._vec[i]-=vector._vec[i];
        }
        return tmp;
    }

    public double scalMul (Vector vector) throws VectorDimentionException
    {
        if (vector.getDimetion()!=this._dimetion)
        {
            throw (new VectorDimentionException ("Vectors have different dimentions"));
        }
        double tmp =0;
        for (int i=0;i<_dimetion;i++)
        {
            tmp+=vector._vec[i]*this._vec[i];
        }

        return tmp;
    }

    public double norm ()
    {
        double tmp = 0;
        for (int i=0;i<_dimetion;i++)
        {
            tmp+=_vec[i]*_vec[i];
        }

        return Math.sqrt(tmp);
    }

    /**
     *
     * @param vector
     * @return Cosinus of angle between Vectors
     * @throws VectorDimentionException
     */
    public double getAngle (Vector vector) throws VectorDimentionException
    {
        if (vector.getDimetion()!=this._dimetion)
        {
            throw (new VectorDimentionException ("Vectors have different dimentions"));
        }

        Double mul = this.scalMul(vector);
        Double mulNorms = this.norm()*vector.norm();
        return mul/mulNorms;
    }


}
